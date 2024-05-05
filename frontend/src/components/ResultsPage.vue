<script setup lang="ts"></script>

<template>
  <div class="containerLogin">
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
    <h1 class="text-center text-3xl font-serif mb-5">Search Results</h1>
    <div class="flex justify-center">
      <div class="w-1/2 ml-28 rbgabgt flex justify-center">
        <div>
          <h3 class="text-3xl text-center pr-16 font-serif my-5">Filter</h3>

          <div>
            <input
              class="!w-[523px] !h-[47px] border-[2px] border-none rounded-md pl-5"
              type="email"
              id="email"
              required
              placeholder="Sort by"
            />
          </div>
          <div class="mt-10">
            <input
              class="!w-[523px] !h-[47px] border-[2px] border-none rounded-md pl-5"
              type="email"
              id="email"
              required
              placeholder="Cuisine"
            />
          </div>
          <div class="!w-[523px] !h-[137px] border-none mt-10 bg-white border-none rounded-md pl-5">
            <p class="text-[#808080] text-xl pt-5">Dietary Requirements</p>
            <div>
              <input type="radio" name="" id="" checked />
            </div>
            <div>
              <input type="radio" name="" id="" />
            </div>
            <div>
              <input type="radio" name="" id="" />
            </div>
          </div>
        </div>
      </div>

      <div class="w-1/2 relative ml-20">
        <form>
          <div>
            <input
              class="!w-[523px] !h-[113px] border-[2px] border-[#a69f9f] bg-[#f4b997] !text-black rounded-md pl-5"
              type="email"
              id="email"
              required
              placeholder="(ICONS)                   Cheese Quesadila"
            />
          </div>
          <div class="mt-10">
            <input
              class="!w-[523px] !h-[113px] border-[2px] border-[#a69f9f] bg-[#f4b997] rounded-md pl-5"
              type="text"
              id="email"
              required
            />
          </div>
          <div class="mt-10">
            <input
              class="!w-[523px] !h-[113px] border-[2px] border-[#a69f9f] bg-[#f4b997] rounded-md pl-5"
              type="text"
              id="email"
              required
            />
          </div>
          <div class="mt-10">
            <input
              type="password"
              id="password"
              class="!w-[523px] !h-[93px] border-[2px] border-[#a69f9f] bg-[#f4b997] rounded-md pl-5"
            />
          </div>
          <p class="text-center absolute bottom-10 left-[30%] text-[#898989] pt-5">
            Scroll for more
          </p>
          <p class="text-center absolute bottom-5 left-[35%] flex justify-center">
            <svg
              width="24"
              height="14"
              viewBox="0 0 24 14"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M12.3338 8.73664L4.17269 0.575524C3.78904 0.191882 3.30077 6.00815e-05 2.70787 6.00815e-05C2.11497 6.00815e-05 1.6267 0.191882 1.24306 0.575524C0.859415 0.959167 0.667589 1.44744 0.667589 2.04034C0.667589 2.63324 0.859415 3.12151 1.24306 3.50515L10.869 13.1311C11.0782 13.3403 11.3049 13.4882 11.5491 13.5747C11.7932 13.6612 12.0548 13.7051 12.3338 13.7065C12.6128 13.7065 12.8744 13.6626 13.1185 13.5747C13.3627 13.4868 13.5894 13.3389 13.7986 13.1311L23.4245 3.50515C23.8082 3.12151 24 2.63324 24 2.04034C24 1.44744 23.8082 0.959167 23.4245 0.575524C23.0409 0.191882 22.5526 6.00815e-05 21.9597 6.00815e-05C21.3668 6.00815e-05 20.8785 0.191882 20.4949 0.575524L12.3338 8.73664Z"
                fill="#898989"
              />
            </svg>
          </p>
        </form>
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
  text-align: left;
  font-size: 25px;
  font-family: sans-serif;
}
.rbgabgt {
  background-color: rgba(139, 69, 19, 0.1);
}
.text_nop {
  font-family: 'Source Serif Pro', serif;
  font-size: 40px;
}
</style>

