import pandas as pd
import pymysql
from sqlalchemy import create_engine


def write_animes(new_date):
    engine = create_engine("mysql+pymysql://root:021112@localhost:3306/daily_anime")
    sql="select * from animes"
    old_date=pd.read_sql_query(sql,engine)
    date=pd.DataFrame(old_date)._append(new_date,ignore_index=True)
    date.drop_duplicates(keep='first',subset=['title'],inplace=True)
    del_table()
    date.to_sql('animes', engine, index=False,if_exists='append')

def del_table():
    conn = pymysql.connect(host="localhost", port=3306, user="root", password="021112", database="daily_anime")
    cursor = conn.cursor()
    cursor.execute("delete from animes")
    conn.commit()
    conn.close()


