<template>
    <div class="calendar">
        <el-tabs  value="Mon" :stretch=true  >
            <el-tab-pane :label="week" v-for="(week,i) in weeks" :key="i" class="calendar_tab">
                <div v-for="(anime,i) in animes" :key="i">
                    <AnimeCardComment v-if="anime.week==week" class="card">
                        <template v-slot:imgdir><img :src="('img'+anime.id+'.jpg')" /> </template>
                        <template v-slot:name>{{ anime.title }}</template>
                        <template v-slot:info>{{ anime.title }}</template>
                    </AnimeCardComment>
                </div>
       
            </el-tab-pane>
        </el-tabs>
    </div>
</template>


<script>
import AnimeCardComment from './AnimeCardComment.vue'


export default {
    components: {
       AnimeCardComment
    },
    data(){
        return{
            weeks :["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
            animes:[]
        }
    },
    created(){
        this.select()
    },
    methods:{
        select(){
            this.axios({     // axios 向后端发起请求
            url: "/calendar/get",  // 请求地址
            method: "post",             // 请求方法
            headers: {                  // 请求头
              "Content-Type": "application/json",
            },
            params: { 
            },
          }).then(response => {
            this.animes = response.data.data
            console.log(response.data)
        })
        }
    }
    
}


</script>


<style>
.calendar{
    width: 60vw;
}
.card{
    float: left;
    margin-left: 20px;
}
</style>

<!-- fdd162    37b484   daac0b -->