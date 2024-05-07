<script setup lang="ts">
import { useUserStore } from '@/stores/UserStore';
const userStore = useUserStore();
</script>

<template>
  <div class="flex w-full h-full relative">
    <div class="left-bg w-1/2 h-screen">
      <div class="pt-5 pl-5">
        <div>
          <button>
            <router-link to="/"><img src="../assets/Cupboard.png" alt="" /></router-link>
          </button>
        </div>
        <div class="ml-5">
          <button>
            <router-link to="/"><img src="../assets/Cookbook.png" alt="" /></router-link>
          </button>
        </div>
      </div>

      <div class="absolute left-[20%] mt-10 px-10">
        <img class="w-[894px] h-[77px]" src="../assets/Simplif.png" alt="" srcset="" />
      </div>

      <div class="absolute top-[40%] left-[10%]">
        <img class="" src="../assets/dontok.png" alt="" srcset="" />
        <div class="flex justify-center">
          <template v-if="userStore.isLoggedIn">
            <button
            class="w-[168px] h-[40px] mt-8 text-[#00635D] text-[18px] border-[1px] border-[#004E49] rounded-[25px] bg-white">
            <router-link to="/Raw"> Continue </router-link>
          </button>
        </template>
        <template v-else>
          <button
            class="w-[168px] h-[40px] mt-8 text-[#00635D] text-[18px] border-[1px] border-[#004E49] rounded-[25px] bg-white">
            <router-link to="/Signin"> Continue </router-link>
          </button>
        </template>
        </div>
      </div>
    </div>

    <!--  -->
    <div class="right-bg w-1/2 h-screen">
      <div class="flex justify-center gap-10 absolute right-3 top-2">
      <template v-if="userStore.isLoggedIn">
        <div class="button-style username-box">
      {{ userStore.currentUser?.username || 'No name' }}
    </div>
        <button @click="userStore.signOut" class="button-style">
          Sign Out
        </button>
      </template>
      <template v-else>
        <router-link to="/signup"><button class="button-style">Sign Up</button></router-link>
        <router-link to="/signin"><button class="button-style">Sign In</button></router-link>
      </template>
      </div>

      <div class="absolute top-[40%] right-[10%]">
        <img class="" src="../assets/dobook.png" alt="" srcset="" />
        <div class="flex justify-center">
          <template v-if="userStore.isLoggedIn">          
            <button
            class="w-[168px] h-[40px] mt-8 text-[#00635D] text-[18px] border-[1px] border-[#004E49] rounded-[25px] bg-white">
            <router-link to="/Recipie"> Continue </router-link>
          </button>
        </template>
        <template v-else>
          <button
            class="w-[168px] h-[40px] mt-8 text-[#00635D] text-[18px] border-[1px] border-[#004E49] rounded-[25px] bg-white">
            <router-link to="/Signin"> Continue </router-link>
          </button>
        </template>

        </div>
      </div>

      <div class="absolute bottom-5 left-[47%]">
        <p class="text-[20px] text-[#898989] text-center">Learn More</p>
        <p class="text-center flex justify-center">
          <svg
            width="24"
            height="14"
            viewBox="0 0 24 14"
            fill="none"
            xmlns="http://www.w3.org/2000/svg">
            <path
              d="M12.3338 8.73664L4.17269 0.575524C3.78904 0.191882 3.30077 6.00815e-05 2.70787 6.00815e-05C2.11497 6.00815e-05 1.6267 0.191882 1.24306 0.575524C0.859415 0.959167 0.667589 1.44744 0.667589 2.04034C0.667589 2.63324 0.859415 3.12151 1.24306 3.50515L10.869 13.1311C11.0782 13.3403 11.3049 13.4882 11.5491 13.5747C11.7932 13.6612 12.0548 13.7051 12.3338 13.7065C12.6128 13.7065 12.8744 13.6626 13.1185 13.5747C13.3627 13.4868 13.5894 13.3389 13.7986 13.1311L23.4245 3.50515C23.8082 3.12151 24 2.63324 24 2.04034C24 1.44744 23.8082 0.959167 23.4245 0.575524C23.0409 0.191882 22.5526 6.00815e-05 21.9597 6.00815e-05C21.3668 6.00815e-05 20.8785 0.191882 20.4949 0.575524L12.3338 8.73664Z"
              fill="#898989"/>
          </svg>
        </p>
      </div>
    </div>
  </div>
</template>

<style scoped>
/* Add your scoped styles here */
.containerLogin {
  padding: 0;
  margin: 0;
  width: 100%;
  height: 100vh;
}
input::placeholder {
  color: black;
  font-style: italic;
  text-align: center;
}

.left-bg {
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, #00e0ff 298.81%);
}
.right-bg {
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, #ff5c00 398.81%);
}
.button-style, .username-box {
  width: 110px; 
  height: 65px; 
  border: 4px solid black;
  border-radius: 4px;
  background-color: #edf1f1;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer; 
}

.username-box {
  cursor: default; 
}
</style>
