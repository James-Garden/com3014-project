import { createRouter, createWebHistory } from "vue-router";
import Home from "./components/Home.vue";
import Signin from "./components/Signin.vue";
import Signup from "./components/signup.vue";
import AccountSetting from "./components/AccountSetting.vue";
import SavedRecipesPage from "./components/SavedRecipes.vue";
import Raw from "./components/Raw.vue";
import Recipie from "./components/Recipie.vue";
import InvidualPage from "./components/Individual.vue";
import ResultPage from "./components/Results.vue";

const routes = [
  { path: "/", component: Home },
  { path: "/signin", component: Signin },
  { path: "/signup", component: Signup },
  { path: "/accountSettings", component: AccountSetting },
  { path: "/SavedPage", component: SavedRecipesPage },
  { path: "/Raw", component: Raw },
  { path: "/Recipie", component: Recipie },
  { path: "/InvidualPage", component: InvidualPage },
  { path: "/ResultPage", component: ResultPage },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
