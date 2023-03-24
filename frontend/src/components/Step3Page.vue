<template>
  <div>
    <h2>개인정보 입력</h2>
    <div>
      <label for="userNameInput">이름</label>
      <input type="text" id="userNameInput" v-model="userName" />
    </div>
    <div>
      <label for="userAgeInput">나이</label>
      <input type="number" id="userAgeInput" v-model="userAge" />
    </div>
    <div>
      <label for="userSexInput">성별</label>
      <select id="userSexInput" v-model="userSex">
        <option value="M">남</option>
        <option value="F">여</option>
      </select>
    </div>
    <div>
      <label for="userAddressInput">주소</label>
      <input type="text" id="userAddressInput" v-model="userAddress" />
    </div>
    <div>
      <label for="userPhoneInput">전화번호</label>
      <input type="text" id="userPhoneInput" v-model="userPhone" />
    </div>
    <div>
      <label for="emailInput">이메일</label>
      <input type="email" id="emailInput" v-model="email" />
    </div>
    <div v-if="isCodeGenerated">
      <label for="approveInput">Approve</label>
      <input type="checkbox" id="approveInput" v-model="approve" :value="1" />
    </div>
    <button type="button" @click="saveData">가입 완료</button>
  </div>
</template>

<script>
import Vuex from 'vuex'
export default {
  name: 'Step3Page',
  data() {
    return {
      userName: '',
      userAge: '',
      userSex: '',
      userAddress: '',
      userPhone: '',
      email: '',
      approve: 0,
      isCodeGenerated: false,
      errorMsg: ''
    };
  },
  methods: {
    saveData() {
      const familyData = {
        code: this.$store.state.signup.familyCode
      };
      const userData = {
        userId: this.$store.state.signup.userId,
        userPw: this.$store.state.signup.userPw,
        userName: this.userName,
        userAge: this.userAge,
        userSex: this.userSex,
        userAddress: this.userAddress,
        userPhone: this.userPhone,
        email: this.email,
        approve: this.approve
      };
      this.$store.dispatch('signup', { familyData, userData }).then(response => {
        if (response.success) {
          this.errorMsg = '';
          this.$router.push({ path: '#/signup/complete' });
        } else {
          this.errorMsg = response.errorMsg;
        }
      }).catch(error => {
        console.log(error);
      });
      
      // 이동할 경로
      const path = '/main.jsp';

      // 라우터 객체 생성
      const router = this.$router;

      // 경로 이동
      router.push({ path });
    },
  },
  mounted() {
    this.isCodeGenerated = this.$store.state.signup.isCodeGenerated;
  },
  computed: {
    ...Vuex.mapState('signup', {
      familyCode: state => state.familyCode,
      userId: state => state.userId,
      userPw: state => state.userPw
    })
  }
};
