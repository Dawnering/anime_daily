import pandas as pd
import pymysql
import requests
from bs4 import BeautifulSoup
from sqlalchemy import create_engine


def get_img():
    engine = create_engine("mysql+pymysql://root:021112@localhost:3306/daily_anime")
    sql = "select * from animes"
    animes = pd.read_sql_query(sql, engine)
    for index, anime in animes.iterrows():
        try:
            if anime.get('img') is None:
                pull_img(anime)
            animes.loc[index,'img']="img"+anime.get("id")+".jpg"
        except Exception as e:
            print(e)
    del_table()
    animes.to_sql('animes', engine, index=False,if_exists='append')



def pull_img(anime):
    print(anime.get('title'))
    url = "https://bgm.tv" + anime.get('href')
    header = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36'}
    data = requests.get(url, headers=header)
    data = (str(data.content, 'utf-8'))
    soup = BeautifulSoup(data)
    src=soup.find_all(class_="cover",name='img')[0]['src']
    image_resp = requests.get("http:"+src)
    with open("../ad_client/public/" +"img"+ anime.id+".jpg", mode="wb") as f:  # 将响应的数据写入文件（地址可自行修改），即该文件就是图片
        f.write(image_resp.content)

def del_table():
    conn = pymysql.connect(host="localhost", port=3306, user="root", password="021112", database="daily_anime")
    cursor = conn.cursor()
    cursor.execute("delete from animes")
    conn.commit()
    conn.close()


if __name__ == "__main__":
    get_img()


