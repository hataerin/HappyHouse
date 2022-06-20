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
      <b-sidebar id="sidebar-right" title="결과" right shadow width="760px" v-model="rsidebar">
        <div class="px-3 py-2">
          <p>
            <b-container>
              <b-row v-for="(housedeal, index) in housedeals" :key="index">
                <div :id="index">
                  <div class="roadview"></div>
                  <b-card>
                    <div>아파트 이름 : {{ housedeal.aptname }}</div>
                    <div>계약년월일: {{ housedeal.dealyearmonth }}{{ housedeal.dealday }}</div>
                    <div>시도군 : {{ housedeal.sidogun }}</div>
                    <div>도로명 : {{ housedeal.roadname }}</div>
                    <div v-if="housedeal.type == 1">아파트(매매)</div>
                    <div v-else-if="housedeal.type == 2">연립다세대(매매)</div>
                    <div v-else-if="housedeal.type == 3">오피스텔(매매)</div>
                    <div>
                      <b-button id="toggle-btn" @click="toggleModal(index)">크게 보기</b-button>
                    </div>
                  </b-card>
                </div>
              </b-row>
            </b-container>
          </p>
        </div>
      </b-sidebar>

      <div id="map" style="width: 100%; height: 100%"></div>
    </div>

    <b-modal id="modal-xl" size="xl" ref="my-modal" hide-footer title="Using Component Methods">
      <div class="d-block text-center">
        <h3>Hello From My Modal!</h3>
        <div id="modalroadview"></div>
        <div @click="showModelroadview">로드 뷰</div>
        <div>아파트 이름 : {{ selectedHouse.aptname }}</div>
        <div>계약년월일: {{ selectedHouse.dealyearmonth }}{{ selectedHouse.dealday }}</div>
        <div>시도군 : {{ selectedHouse.sidogun }}</div>
        <div>도로명 : {{ selectedHouse.roadname }}</div>
        <div v-if="selectedHouse.type == 1">아파트(매매)</div>
        <div v-else-if="selectedHouse.type == 2">연립다세대(매매)</div>
        <div v-else-if="selectedHouse.type == 3">오피스텔(매매)</div>
      </div>
      <!--  <b-button class="mt-3" variant="outline-warning" block @click="toggleModal(-1)">Toggle Me</b-button>-->
    </b-modal>
  </div>
</template>

<script>
var marker = [];
var facilities = [];
var markerlat = [];
var markerlng = [];
var prev;

export default {
  data() {
    return {
      selectedHouse: '',
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
      modals: {
        classic: false,
      },
    };
  },
  created() {
    //    this.$store.dispatch('getAllHouseDeal');
  },
  mounted() {
    this.makeMap();
  },
  methods: {
    toggleModal(index) {
      // We pass the ID of the button that we want to return focus to
      // when the modal has hidden
      this.$refs['my-modal'].toggle('#toggle-btn');
      this.selectedHouse = this.housedeals[index];
      console.log(this.selectedHouse);
    },
    showModelroadview() {
      var modalroadviewContainer = document.getElementById('modalroadview');
      //로드뷰를 표시할 div
      var modalroadview = new kakao.maps.Roadview(modalroadviewContainer); //로드뷰 객체
      var modalroadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

      var modalposition = new kakao.maps.LatLng(this.selectedHouse.lat, this.selectedHouse.lng);

      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      modalroadviewClient.getNearestPanoId(modalposition, 50, function(modalpanoId) {
        modalroadview.setPanoId(modalpanoId, modalposition); //panoId와 중심좌표를 통해 로드뷰 실행
      });
    },

    makeModal() {
      console.log('asd');
    },
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
      if (prev != null) {
        let removetarget = document.getElementById(prev);
        removetarget.classList.remove('selected');
        removetarget.querySelector('.roadview').classList.remove('selectedroadview');
        //  document.getElementById(prev).removeAttribute('selected');
      }

      document.getElementById(index).classList.add('selected');
      let lat = this.housedeals[index].lat;
      let lng = this.housedeals[index].lng;
      this.map.setCenter(new kakao.maps.LatLng(lat, lng));
      prev = index;
      this.map.setLevel(4);
      var roadviewContainer = document.querySelector('.selected').querySelector('.roadview'); //로드뷰를 표시할 div
      roadviewContainer.classList.add('selectedroadview');
      var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
      var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

      var position = new kakao.maps.LatLng(lat, lng);

      // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
      roadviewClient.getNearestPanoId(position, 50, function(panoId) {
        roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
      });
      document.getElementById(index).scrollIntoView();
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
.selected {
  border: 3px green solid;
}
.selectedroadview {
  width: 100%;
  height: 600px;
}
#modalroadview {
  z-index: 100;
  position: absolute;
  top: 500px;
  left: 500px;
}
</style>
