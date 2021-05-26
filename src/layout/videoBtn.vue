<template>
  <div>
    <button class=".VideoBtn">+</button>
  </div>
</template>

<script>
export default {
  methods: {
    goVideo() {
      this.$route.replace('/video');
    },
  },
};
</script>

<style scoped>
.VideoBtn {
  background-color: #4caf50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
</style>
