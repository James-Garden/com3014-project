<script setup lang="ts">
import { useUserStore } from '@/stores/UserStore';
const userStore = useUserStore();
</script>
<template>
  <div class="w-full relative left-bg h-screen">
    <div class="flex">
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

      <div class="mt-20 flex justify-center pl-60">
        <img class="w-[532px] h-[67px]" src="../assets/searchss.png" alt="" srcset="" />
      </div>
    </div>
    <div class="mt-10 flex justify-center">
      <div>
        <input
          type="text"
          id="text"
          class="!w-[914px] !h-[49px] rounded-md pl-5"
          placeholder="Search by Recipe"
        />
      </div>
      <div class="bg-white w-[150px] shadow-2xl !h-[49px] border-[2px] border-[#8e8b8b]">
        <p class="text-md text-center items-center pt-3">Filter</p>
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
  color: #9b9b9b;
  text-align: left;
}

.left-bg {
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, #ff5c00 498.81%);
}
.right-bg {
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, #ff5c00 398.81%);
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
