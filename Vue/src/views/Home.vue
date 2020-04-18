<template>
    <div>
        <h1>留言版</h1>
        <el-input
                type="text"
                placeholder="请输入你的名字"
                v-model="messageBoard.author"
                maxlength="16"
                show-word-limit
        >
        </el-input>
        <div style="margin: 20px 0;"></div>
        <el-input
                type="textarea"
                placeholder="请输入留言"
                v-model="messageBoard.message"
                show-word-limit
        >
        </el-input>
        <div style="margin: 20px 0;"></div>
        <el-button type="primary" plain @click="postMessage">留言</el-button>
        <el-divider></el-divider>
        <el-table
                :data="messages"
                height="250"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="序号"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="名字">
            </el-table-column>
            <el-table-column
                    prop="message"
                    label="留言">
            </el-table-column>
            <el-table-column
                    prop="time"
                    label="时间"
                    width="160">
            </el-table-column>
        </el-table>
        <el-link type="primary" href="https://github.com/Enaium">By Enaium</el-link>
    </div>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
                messageBoard: {
                    author: '',
                    message: ''
                },
                messages: []
            }
        },
        methods: {
            postMessage() {
                if (this.messageBoard.author === '') {
                    this.$message.error('请输入你的名字');
                    return
                }

                if (this.messageBoard.message === '') {
                    this.$message.error('请输入留言');
                    return
                }

                axios.get("http://localhost:8181/postMessage?author=" + this.messageBoard.author + "&message=" + this.messageBoard.message).then((t) => {
                    if (t.data === 'success') {
                        this.$message({
                            message: '留言成功',
                            type: 'success'
                        });
                    } else {
                        this.$message.error('留言失败');
                    }
                })
            }
        },
        created() {
            axios.get("http://localhost:8181/getMessages").then((t) => {
                this.messages = t.data
            })
        }
    }
</script>