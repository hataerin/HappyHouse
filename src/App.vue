<template>
  <div id="app">
    <router-view name="header" />
    <div class="wrapper" style="padding-top: 55px">
      <router-view />
    </div>
    <router-view name="footer" />
  </div>
</template>
<script>
export default {
  mounted() {
    //   console.log('asd');
    //   this.$store.dispatch('getSession');
  },
};
</script>
