import axios from 'axios';

const state = {
    familyCode: '',
    userId: '',
    userPw: '',
    userData: {
      userName: '',
      userAge: '',
      userSex: '',
      userAddress: '',
      userPhone: '',
      email: '',
      approve: false
    },
    isCodeGenerated: false,
    isIdValid: false,
    isUserPwValid: false
  };
  
  const mutations = {
    SET_FAMILY_CODE(state, code) {
      state.familyCode = code;
    },
    SET_USER_ID(state, id) {
      state.userId = id;
    },
    SET_USER_PW(state, pw) {
      state.userPw = pw;
    },
    SET_USER_DATA(state, userData) {
      state.userData = userData;
    },
    SET_CODE_GENERATED(state, isGenerated) {
      state.isCodeGenerated = isGenerated;
    },
    SET_ID_VALID(state, isValid) {
      state.isIdValid = isValid;
    },
    SET_USER_PW_VALID(state, isValid) {
      state.isUserPwValid = isValid;
    },
  actions: {
    signup({ commit }, { familyData, userData }) {
      return new Promise((resolve, reject) => {
        axios.post('/api/user/signup', { family: familyData, user: userData })
          .then(response => {
            if (response.data.success) {
              commit('SET_FAMILY_CODE', familyData.code);
              commit('SET_USER_ID', userData.userId);
              commit('SET_USER_PW', userData.userPw);
              commit('SET_CODE_GENERATED', true);
              resolve({ success: true });
            } else {
              reject({ success: false, errorMsg: response.data.errorMsg });
            }
          })
          .catch(error => {
            reject({ success: false, errorMsg: error });
          });
      });
    }
  }
};
  export default {
    state,
    mutations
};
  