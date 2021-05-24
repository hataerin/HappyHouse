<template>
  <div>
    <div style="width:100%; height:100vh;">
      <div id="map" style="width: 100%; height: 100%"></div>
    </div>
  </div>
</template>
<script>
export default {
  computed: {
    housedeals() {
      console.log('asd'); // promise
      /*   console.log(this.$store.getters.housedeals);
      for (let i = 0; i < this.$store.getters.housedeals.length / 10; i++) {
        marker = new kakao.maps.Marker(this.$store.getters.housedeals[i].lat, this.$store.getters.housedeals[i].lng);
        console.log(this.$store.getters.housedeals[i]);
        marker.setMap(map);
      }*/
      //this.$store.state.housedeal
      return this.$store.getters.housedeals;
    },
  },
  created() {
    //    this.$store.dispatch('getAllHouseDeal');
  },
  mounted() {
    //    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  methods: {
    initMap() {
      var container = document.getElementById('map');
      var options = { center: new kakao.maps.LatLng(37.7615193, 128.8679689), level: 12 };
      var map = new kakao.maps.Map(container, options); //마커추가하려면 객체를 아래와 같이 하나 만든다.
      //  new kakao.maps.Map(container);
      var marker = new kakao.maps.Marker({ position: map.getCenter() });
      marker.setMap(map);
    },
    addScript() {
      const script = document.createElement('script'); /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=29c19b3dda898f4062f070cabd9f2ab1';
      document.head.appendChild(script);
    },
  },
};
</script>
<style scoped></style>
