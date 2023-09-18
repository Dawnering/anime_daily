import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
axios.defaults.baseURL='/api'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

createApp(App).use(store).use(router).use(ElementPlus).use(VueAxios,axios).use(ElementPlusIconsVue).mount('#app')
