<template>
  <div style="background-image: linear-gradient(to bottom right, #89e5c9, #4f66d5);height: 100vh; padding-top: 60px;">
    <el-card style="width: 30%; margin-left: 35%; margin-top: 0px; border-radius: 40px">
      <h2
        style="width: 30%; display: block; margin-left: 35%; text-align: center; margin-bottom: 20px; font-weight: 700">
        用 户 登 录</h2>
      <el-form :model="user" :rules="rules" ref="userForm" style="width: 80%; margin-left: 10%;">
        <el-form-item prop="username">
          <el-input placeholder="请输入用户名" prefix-icon="el-icon-user" v-model="user.username">
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input placeholder="请输入密码" prefix-icon="el-icon-lock" v-model="user.password" show-password>
          </el-input>
        </el-form-item>
        <el-button @click="login" type="primary"
          style="height: 50px; float: right;border-radius: 10px; margin-bottom: 20px; width: 100%; margin-top: 15px; font-weight: 700;">
          登 录
        </el-button>
      </el-form>
    </el-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {}
    }
  },
  methods: {
    login() {
      this.$router.replace('/userinfo')
    },
  }
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

.el-input {
  margin-bottom: 0px;
}
</style>