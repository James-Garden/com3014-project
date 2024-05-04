<script setup lang="ts"></script>

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
        <p class="underline text-[34px]">
          <router-link to="/signup"> Sign Up </router-link>
        </p>
        <button
          class="w-[110px] h-[65px] border border-[4px] border-[#000000] rounded-md bg-[#edf1f1]"
          type="submit"
        >
          <router-link to="/signin"> Sign In </router-link>
        </button>
      </div>
    </div>
    <div class="flex justify-center mx-auto">
      <!-- <img class="w-[732px] h-[77px] block" src="../assets/addraw.png" alt="" srcset="" /> -->
      <p class="texts">Add raw ingredients to your virtual pantry.</p>
    </div>
    <div class="mt-10 flex justify-center">
      <div>
        <input
          type="password"
          id="password"
          class="!w-[914px] !h-[49px] rounded-md pl-5"
          placeholder="Search by Ingredient"
          readonly
        />
        <div class="bg-white w-[250px] rounded-md shadow-2xl h-[200px] mt-10">
          <p class="p-4 text-md">Grated Cheese</p>
          <p class="pl-4 text-md">Rice</p>
          <p class="pl-4 pt-4 pb-4 text-md">Chicken Breast</p>
          <p class="pl-4 text-md">Milk</p>
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
}
input::placeholder {
  color: #9b9b9b;
  font-style: italic;
  text-align: left;
}

.left-bg {
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, #00e0ff 298.81%);
}
.right-bg {
  background: linear-gradient(178.54deg, rgba(255, 92, 0, 0) 1.24%, #ff5c00 398.81%);
}
</style>
