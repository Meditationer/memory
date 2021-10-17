# uni-app

## 目录结构

- cloudfunctions 云函数目录（阿里云为aliyun，腾讯云为tcb）
- common 是存放公共js和css的目录
- components uni-app组件目录，放可复用的组件  vue组件
  - comp -a.vue可复用的a组件
- pages 业务页面文件存放的目录
- static 存放应用引用静态资源（如图片、视频等）的地方，注意：静态资源只能存放于此
- App.vue 应用配置，用来配置App全局样式以及监听 应用生命周期
- main.js Vue初始化入口文件
- mainfest.json 配置应用名称、appid、logo、版本等打包信息，项目运行发布配置
- pages.json 配置页面路由、导航条、选项卡等页面类信息，详见
- unpackage 打包项目
- wxcomponents 小程序组件目录
- hybrid 本地网页目录
- platforms 各平台专用页面
