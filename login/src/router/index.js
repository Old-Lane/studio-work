import vue from 'vue'
import VueRouter from 'vue-router'

vue.use(VueRouter)

const routes = [
  {
    path: '',
    redirect: '/login',
    component: () => import('../App.vue'),
    children: [
      {
        path: 'login',
        name: 'Login',
        component: () => import('../views/login.vue')
      },
      {
        path: 'userinfo',
        name: 'UserInfo',
        component: () => import('../views/user-info.vue')
      }
    ]
  },

]

const router = new VueRouter({
  routes
})

export default router