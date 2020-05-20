#综合的springboot项目
##git的使用
>创建远程仓库
>
>克隆远程仓库到本地
>```shell script
>git clone 远程仓库地址
>```
>提交代码
>```shell script
>git add . #提交代码到暂存区
>git commit -m 提交说明 #提交代码到本地仓库
>git push 远程仓库地址 提交分支 #提交代码到远程仓库
>```
>不小心提交了多余的文件
>```shell script
>git rm -r --cached 文件名
>#删除指定文件后再提交代码
>```