<script setup lang="ts">
import { ref } from 'vue';

const userName = localStorage.getItem('username');
const isLoggedIn = ref(userName !== null);
</script>

<template>
  <div class="w-full relative left-bg h-screen">
    <div class="flex">
      <div class="pt-5 pl-5">
        <div>
          <button>
            <router-link to="/"><p class="text_nop">Cupboard</p></router-link>
          </button>
        </div>
        <div class="ml-5">
          <button>
            <router-link to="/"><p class="text_nop">Cookbook</p></router-link>
          </button>
        </div>
      </div>
      <div class="flex justify-center gap-10 absolute right-3 top-2">
        <p v-if="isLoggedIn" class="underline text-[34px]">Logout</p>
        <p v-if="!isLoggedIn" class="underline text-[34px]">
          <router-link to="/signup"> Sign Up </router-link>
        </p>

        <router-link v-if="!isLoggedIn" to="/signin">
          <button
            class="w-[110px] h-[65px] border border-[4px] border-[#000000] rounded-md bg-[#edf1f1]"
            type="button"
          >
            Sign In
          </button>
        </router-link>
      </div>

      <div class="mt-20 flex justify-center pl-60">
        <!-- <img class="w-[532px] h-[67px]" src="../assets/searchss.png" alt="" srcset="" /> -->
        <p class="texts pl-16">Search here for recipies</p>
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
.text_nop {
  font-family: 'Source Serif Pro', serif;
  font-size: 40px;
}
.texts {
  font-family: 'Newsreader', Georgia, 'Times New Roman', Times, serif;
  font-size: 40px;
}
</style>

