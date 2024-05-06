<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter();
const userName = localStorage.getItem('username');
const isLoggedIn = ref(userName !== null);
const logout = () => {
  localStorage.removeItem('username');
  localStorage.removeItem('password');
  localStorage.removeItem('email');
    window.location.reload();

  router.push('/');
};
</script>
<template>
  <div class="">
    <div class="w-1/2">
      <div class="flex justify-center gap-10 absolute right-3 top-2">
    
        <p v-if="isLoggedIn" @click="logout" class="underline text-[34px]">Logout</p>
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
    </div>
  </div>
</template>
<style scoped>
/* Add your scoped styles here */
.containerLogin {
  padding: 0;
  margin: 0;
  width: 100%;
  height: 200px;
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
.text_nop {
  font-family: 'Source Serif Pro', serif;
  font-size: 40px;
}
.text_ok {
  font-family: 'Newsreader', serif;
  font-size: 64px;
}
.texts {
  font-family: 'Newsreader', serif;
  font-size: 40px;
}
</style>

