const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports={
  publicPath:'./',
  devServer:{
    hot:false,
    proxy:{
      '/api':{
      //  target:'http://110.40.223.140:8089/',
       target:'http://localhost:8089/',
        changeOrigin:true,
        pathRewrite:{'^/api':'/'}
      }
    }
  },
  chainWebpack: config => {
    config.plugins.delete('prefetch')
    config.plugins.delete('preload')
  }
}

