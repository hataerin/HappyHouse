<template>
  <div>
    <div style="width:100%; height:100vh;">
      <b-button v-b-toggle.sidebar-1 id="searchBar">Search</b-button>
      <b-sidebar id="sidebar-1" title="검색" shadow v-model="lsidebar">
        <div class="px-3 py-2">
          <p>
            <b-input-group size="sm" class="mb-2">
              <b-input-group-prepend is-text>
                <b-icon icon="search"></b-icon>
              </b-input-group-prepend>
              <b-form-input
                type="search"
                placeholder="Search text"
                v-model="searchtext"
                @keyup.enter="searchHouseDeals"
              ></b-form-input>
            </b-input-group>
            <button @click="searchHouseDeals">검색</button>
          </p>
        </div>
      </b-sidebar>

      <div style="display:none;">
        <b-button v-b-toggle.sidebar-right id="houseDealResult">Toggle Sidebar</b-button>
      </div>
      <b-sidebar id="sidebar-right" title="결과" right shadow v-model="rsidebar">
        <div class="px-3 py-2">
          <p>
            <b-container>
              <b-row v-for="(housedeal, index) in housedeals" :key="index">
                <div>
                  <b-card>
                    <div>아파트 이름 : {{ housedeal.aptname }}</div>
                    <div>계약년월일: {{ housedeal.dealyearmonth }}{{ housedeal.dealday }}</div>
                    <div>시도군 : {{ housedeal.sidogun }}</div>
                    <div>도로명 : {{ housedeal.roadname }}</div>
                    <div v-if="housedeal.type == 1">아파트(매매)</div>
                    <div v-else-if="housedeal.type == 2">연립다세대(매매)</div>
                    <div v-else-if="housedeal.type == 3">오피스텔(매매)</div>
                  </b-card>
                </div>
              </b-row>
            </b-container>
          </p>
        </div>
      </b-sidebar>

      <div id="map" style="width: 100%; height: 100%"></div>
    </div>
  </div>
</template>

<script>
var marker = [];
var overlay = [];
export default {
  data() {
    return {
      housedeals: '',
      searchtext: '',
      map: '',
      rsidebar: false,
      lsidebar: false,
    };
  },
  created() {
    //    this.$store.dispatch('getAllHouseDeal');
  },
  mounted() {
    this.makeMap();
  },
  methods: {
    initMap() {
      var container = document.getElementById('map');
      var options = { center: new kakao.maps.LatLng(37.4815193, 127.0379689), level: 11 };
      this.map = new kakao.maps.Map(container, options); //마커추가하려면 객체를 아래와 같이 하나 만든다.
      //  new kakao.maps.Map(container);
      //      var marker = new kakao.maps.Marker({ position: map.getCenter() });
    },
    pointMaker() {
      for (let i = 0; i < marker.length; i++) {
        marker[i].setMap(null);
      }
      marker = [];
      let lat = 37.56605862636895;
      let lng = 126.98020317219742;
      if (this.housedeals && this.housedeals.length > 0) {
        lat = this.housedeals[0].lat;
        lng = this.housedeals[0].lng;
      }
      this.map.setCenter(new kakao.maps.LatLng(lat, lng));
      for (let i = 0; i < this.housedeals.length; i++) {
        console.log(this.housedeals[i]);
        marker.push(
          new kakao.maps.Marker({
            map: this.map,
            position: new kakao.maps.LatLng(this.housedeals[i].lat, this.housedeals[i].lng),
            title: this.housedeals[i].aptname,
          })
        );
        // overlay.push(
        //   new kakao.maps.CustomOverlay({
        //     content:
        //       '<div class="wrap">' +
        //       '    <div class="info">' +
        //       '        <div class="title">' +
        //       '            카카오 스페이스닷원' +
        //       '            <div class="close" onclick="closeOverlay()" title="닫기"></div>' +
        //       '        </div>' +
        //       '        <div class="body">' +
        //       '            <div class="desc">' +
        //       '                <div class="ellipsis">제주특별자치도 제주시 첨단로 242</div>' +
        //       '                <div class="jibun ellipsis">(우) 63309 (지번) 영평동 2181</div>' +
        //       '                <div><a href="https://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>' +
        //       '            </div>' +
        //       '        </div>' +
        //       '    </div>' +
        //       '</div>',
        //     map: this.map,
        //     position: marker[i].getPosition(),
        //   })
        // );
        // kakao.maps.event.addListener(marker[i], 'click', function() {
        //   overlay[i].setMap(map);
        // });
      }
    },
    addScript() {
      const script = document.createElement('script'); /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=29c19b3dda898f4062f070cabd9f2ab1';
      document.head.appendChild(script);
    },
    makeMap() {
      var _this = this;
      window.kakao && window.kakao.maps ? _this.initMap() : _this.addScript();
      /*  return new Promise(function(resolve) {
        _this.$store.dispatch('getAllHouseDeal').then(function() {
          console.log('get:', _this.$store.getters.housedeals);
          _this.housedeals = _this.$store.getters.housedeals;

        });
      });*/
    },
    async searchHouseDeals() {
      console.log('search');
      var _this = this;
      let result = await _this.$store.dispatch('searchHouseDeal', _this.searchtext); //1
      console.log('search:', _this.$store.getters.housedeals);
      if (result) {
        _this.housedeals = _this.$store.getters.housedeals;
        _this.pointMaker();
        //  document.querySelector('#sidebar-right').style.display = '';
        //  document.querySelector('#sidebar-1').style.display = 'none';
        this.rsidebar = true;
        this.lsidebar = false;
      } else {
        console.log('에러');
      }
    },
  },
};
</script>
<style scoped>
#searchBar {
  position: absolute;
  z-index: 100;
  top: 70px;
  left: 20px;
}
</style>
