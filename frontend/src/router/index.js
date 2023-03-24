/**
 * 
 */
import Vue from 'vue'
import VueRouter from 'vue-router'
import Step1 from '../components/Step1Page.vue'
import Step2 from '../components/Step2Page.vue'
import Step3 from '../components/Step3Page.vue'
import SignupPage from '../components/SignupPage.vue'
import store from '../store/modules/signup.js';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: '/step1'
  },
  {
    path: '/step1',
    name: 'Step1Page',
    component: Step1
  },
  {
    path: '/step2',
    name: 'Step2Page',
    component: Step2
  },
  {
    path: '/step3',
    name: 'Step3Page',
    component: Step3
  },
  {
    path: '/signuppage',
    name: 'SignupPage',
    component: SignupPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.store=store;

export default router