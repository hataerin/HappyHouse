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
            <b-form-group label="좋아하는 시설" v-slot="{ ariaDescribedby }">
              <b-form-checkbox-group
                id="checkbox-group-1"
                v-model="selected"
                :options="options"
                :aria-describedby="ariaDescribedby"
                name="flavour-1"
              ></b-form-checkbox-group>
            </b-form-group>

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
var facilities = [];
var markerlat = [];
var markerlng = [];
export default {
  data() {
    return {
      housedeals: '',
      searchtext: '',
      map: '',
      rsidebar: false,
      lsidebar: false,

      selected: [], // Must be an array reference!
      options: [
        { text: '은행', value: '0', target: 'BK9', dataorder: '0' },
        { text: '마트', value: '1', target: 'MT1', dataorder: '1' },
        { text: '약국', value: '2', target: 'PM9', dataorder: '2' },
        { text: '주유소', value: '3', target: 'OL7', dataorder: '3' },
        { text: '카페', value: '4', target: 'CE7', dataorder: '4' },
        { text: '편의점', value: '5', target: 'CS2', dataorder: '5' },
      ],
    };
  },
  created() {
    //    this.$store.dispatch('getAllHouseDeal');
  },
  mounted() {
    this.makeMap();
  },
  methods: {
    getFacilities(si, index) {
      var _this = this;
      console.log('getFacilities');
      var places = new kakao.maps.services.Places();
      var callback = function(result, status, pagination) {
        console.log(result);
        if (status === kakao.maps.services.Status.OK) {
          for (let i = 0; i < result.length; i++) {
            //  let imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png', // 마커이미지의 주소입니다\
            let imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png', // 마커이미지의 주소입니다\
              imageSize = new kakao.maps.Size(30, 30), // 마커이미지의 크기입니다
              imageOption = {
                spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
                spriteOrigin: new kakao.maps.Point(46, _this.options[si].dataorder * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
                offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
              };
            console.log(imageSrc);
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
              markerPosition = new kakao.maps.LatLng(result[i].y, result[i].x); // 마커가 표시될 위치입니다
            // var fmarker = new kakao.maps.Marker({
            //   map: _this.map,
            //   position: markerPosition,
            //   image: markerImage, // 마커이미지 설정
            // });
            // facilities.push(fmarker);
            facilities.push(
              new kakao.maps.Marker({
                map: _this.map,
                position: markerPosition,
                image: markerImage, // 마커이미지 설정
              })
            );
            //fmarker.setMap(_this.map);
            //  facilities[i].setMap(_this.map);
          }
        }
      };
      places.categorySearch(this.options[si].target, callback, {
        location: new kakao.maps.LatLng(markerlat[index], markerlng[index]),
        radius: 200,
      });
    },
    initMap() {
      var container = document.getElementById('map');
      let options = { center: new kakao.maps.LatLng(37.4815193, 127.0379689), level: 11 };
      this.map = new kakao.maps.Map(container, options); //마커추가하려면 객체를 아래와 같이 하나 만든다.
      //  new kakao.maps.Map(container);
      //      var marker = new kakao.maps.Marker({ position: map.getCenter() });
    },
    pointMaker() {
      var _this = this;
      for (let i = 0; i < marker.length; i++) {
        marker[i].setMap(null);
      }
      for (let i = 0; i < facilities.length; i++) {
        facilities[i].setMap(null);
      }
      facilities = [];
      marker = [];
      markerlat = [];
      markerlng = [];
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
        markerlat.push(this.housedeals[i].lat);
        markerlng.push(this.housedeals[i].lng);
      }
      for (let i = 0; i < marker.length; i++) {
        kakao.maps.event.addListener(marker[i], 'click', function() {
          _this.markerClick(i);
        });
      }
    },
    markerClick(index) {
      for (let i = 0; i < facilities.length; i++) {
        facilities[i].setMap(null);
      }
      facilities = [];
      for (let i = 0; i < this.selected.length; i++) {
        this.getFacilities(this.selected[i], index);
      }
    },
    addScript() {
      const script = document.createElement('script'); /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=29c19b3dda898f4062f070cabd9f2ab1';
      document.head.appendChild(script);

      const script1 = document.createElement('script'); /* global kakao */
      script1.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=29c19b3dda898f4062f070cabd9f2ab1&libraries=LIBRARY';
      document.head.appendChild(script1);
      const script2 = document.createElement('script'); /* global kakao */
      script2.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=29c19b3dda898f4062f070cabd9f2ab1&libraries=services';
      document.head.appendChild(script2);
    },
    makeMap() {
      var _this = this;
      window.kakao && window.kakao.maps ? _this.initMap() : _this.addScript();
    },
    async searchHouseDeals() {
      console.log('search');
      var _this = this;
      let result = await _this.$store.dispatch('searchHouseDeal', _this.searchtext); //1
      console.log('search:', _this.$store.getters.housedeals);
      if (result) {
        _this.housedeals = _this.$store.getters.housedeals;
        _this.pointMaker();
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
