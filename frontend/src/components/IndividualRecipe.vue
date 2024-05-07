<script setup lang="ts">
import { useUserStore } from '@/stores/UserStore';
const userStore = useUserStore();
</script>
<template>
  <div class="containerLogin">
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
    </div>
    <div class="flex justify-center">
      <div
        class="w-[800px] h-[500px] flex rounded-md shadow-xl bg-[#fdd1b7] border border-[#645b5b]">
        <div class="w-1/2 pt-10">
          <p class="text-[31px] text-center font-serif">Cheese Quesadilla</p>
          <div class="mt-8 text-[26px] text-center underline font-serif">Ingredients</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
        </div>
        <div class="w-1/2 pt-10">
          <p class="text-[31px] text-center underline font-serif">Method</p>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
          <div class="mt-8 text-[26px] text-center font-serif">-</div>
        </div>
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
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, rgba(255, 92, 0, 0.1755) 98.81%),
    linear-gradient(360deg, rgba(0, 224, 255, 0) 0%, rgba(0, 224, 255, 0.2) 100%);
}
input::placeholder {
  color: black;
  font-style: italic;
  text-align: center;
}
.button-style, .username-box {
  width: 110px; /* Adjust width as needed */
  height: 65px; /* Adjust height as needed */
  border: 4px solid black;
  border-radius: 4px;
  background-color: #edf1f1;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer; /* Remove if it is not clickable */
}

.username-box {
  cursor: default; /* If it's not supposed to be clickable */
}
</style>
