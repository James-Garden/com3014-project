import { createRouter, createWebHistory } from 'vue-router'
import Home from "@/components/Home.vue";
import SignIn from "@/components/SignIn.vue";
import SignUp from "@/components/SignUp.vue";
import AccountSetting from "@/components/AccountSetting.vue";
import SavedRecipes from "@/components/SavedRecipes.vue";
import Raw from "@/components/Raw.vue";
import Recipe from "@/components/Recipe.vue";
import Individual from "@/components/Individual.vue";
import Results from "@/components/Results.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", component: Home },
    { path: "/signin", component: SignIn },
    { path: "/signup", component: SignUp },
    { path: "/accountSettings", component: AccountSetting },
    { path: "/SavedPage", component: SavedRecipes },
    { path: "/Raw", component: Raw },
    { path: "/Recipie", component: Recipe },
    { path: "/InvidualPage", component: Individual },
    { path: "/ResultPage", component: Results },
  ]
})

export default router
