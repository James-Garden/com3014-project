<script setup lang="ts"></script>

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
    </div>
    <div class="flex justify-center mt-10 px-10">
      <img class="w-[894px] h-[77px]" src="../assets/Simplif.png" alt="" srcset="" />
    </div>
    <div class="flex mt-12 justify-center">
      <form @submit.prevent="signIn">
        <div>
          <input
            class="!w-[914px] !h-[49px] rounded-md pl-5"
            type="email"
            id="email"
            placeholder="Email"
            v-model="email"
            required
          />
        </div>
        <div class="mt-10">
          <input
            class="!w-[914px] !h-[49px] rounded-md pl-5"
            type="text"
            id="email"
            placeholder="Username"
            v-model="email"
            required
          />
        </div>
        <div class="mt-10">
          <input
            type="password"
            id="password"
            v-model="password"
            class="!w-[914px] !h-[49px] rounded-md pl-5"
            placeholder="Password"
          />
        </div>

        <div class="flex justify-center mt-10">
          <button
            class="w-[110px] h-[65px] border border-[4px] border-[#000000] rounded-md bg-[#9ae4ed]"
            type="submit"
          >
            Sign Up
          </button>
        </div>
      </form>
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

.signin h2 {
  margin-bottom: 20px;
}

.signin form div {
  margin-bottom: 15px;
}

.signin form label {
  display: block;
  margin-bottom: 5px;
}

.signin form input {
  width: 100%;
  padding: 8px;
  border-radius: 4px;
}

.signin form button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.signin form button:hover {
  background-color: #0056b3;
}
</style>
