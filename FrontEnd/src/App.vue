<template>
  <div id="app">
    <router-view name="header" />
    <div class="wrapper" style="padding-top: 55px;">
      <router-view />
    </div>
    <router-view name="footer" />
  </div>
</template>
<script>
import { Button } from '@/components';
export default {
  components: {
    [Button.name]: Button,
  },
  mounted() {
    //   console.log('asd');
    //   this.$store.dispatch('getSession');
  },
  methods: {
    goVideo() {
      this.$router.replace('/video');
    },
  },
};
</script>

<style scoped>
#VideoBtn {
  color: red;
  background-color: white;
  height: 150px;
  width: 200px;
  top: 90%;
  left: 90%;
}
</style>
