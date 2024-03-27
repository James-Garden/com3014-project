<template>
  <div class="containerLogin">
    <div class="pt-5 pl-5">
      <div>
        <img src="../assets/Cupboard.png" alt="" />
      </div>
      <div class="ml-5">
        <img src="../assets/Cookbook.png" alt="" />
      </div>
    </div>
    <div class="flex justify-center mt-6 px-10">
      <img
        class="w-[457px] h-[77px]"
        src="../assets/AccountSettings.png"
        alt=""
        srcset=""
      />
    </div>
    <div class="flex mt-12 justify-center">
      <form @submit.prevent="signIn">
        <div>
          <input
            class="!w-[424px] !h-[54px] border-[2px] border-[#000000] bg-[#f4b997] !text-black rounded-md pl-5"
            type="email"
            id="email"
            placeholder="Change Details"
            v-model="email"
            required
          />
        </div>
        <div class="mt-10">
          <input
            class="!w-[424px] !h-[54px] border-[2px] border-[#000000] bg-[#f4b997] rounded-md pl-5"
            type="text"
            id="email"
            placeholder="Saved Recipes"
            v-model="email"
            required
          />
        </div>
        <div class="mt-10">
          <input
            type="password"
            id="password"
            v-model="password"
            class="!w-[424px] !h-[54px] border-[2px] border-[#000000] bg-[#f4b997] rounded-md pl-5"
            placeholder="Log Out"
          />
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "AccountSettingsPage",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  methods: {
    signIn() {
      // Perform sign-in logic here
      console.log("Email:", this.email);
      console.log("Password:", this.password);
      // Example: You can send the email and password to an API for authentication
    },
  },
};
</script>

<style scoped>
/* Add your scoped styles here */
.containerLogin {
  padding: 0;
  margin: 0;
  width: full;
  height: 100vh;
  background: linear-gradient(
      178.54deg,
      rgba(255, 92, 0, 0) 1.24%,
      rgba(255, 92, 0, 0.1755) 98.81%
    ),
    linear-gradient(
      360deg,
      rgba(0, 224, 255, 0) 0%,
      rgba(0, 224, 255, 0.2) 100%
    );
}
input::placeholder {
  color: black;
  font-style: italic;
  text-align: center;
}
</style>
