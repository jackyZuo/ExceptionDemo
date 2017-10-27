## **前言**

### 本地开发的时候运行正常，开启了混淆之后编译通过运行失败


## **描述**

### 项目中遇到了一个问题，module中有一个方法，改方法会抛Exception，

```
    public Map<String, String> encryptParams(Map<String, String> params) throws Exception {
        return params;
    }
```

####  在主工程中有一个改类的子类复写类该方法，做了一些其他的逻辑，开发的时候为类方便把混淆关了直接关联工程开发。调试完毕之后开了混淆准备打包然后就build 失败。

![0001](https://github.com/jackyZuo/ExceptionDemo/blob/master/images/0001.png)


#### 根据提示判断是因为父类中的encryptParams（）方法未抛Exception，所以子类也不能抛。看代码确定是有throw Exception的，于是Module打出来的jar反编译下看看到底有没有。


#### [JD-GUI](http://jd.benow.ca/)可以很方便的反编译jar包。使用AndroidStudio更方便直接把jar拖到libs下面，然后sync。


![0002](https://github.com/jackyZuo/ExceptionDemo/blob/master/images/0002.png)


#### 可以看到混淆后的代码


![0003](https://github.com/jackyZuo/ExceptionDemo/blob/master/images/0003.png)


#### 来一张对比的

![0004](https://github.com/jackyZuo/ExceptionDemo/blob/master/images/0004.png)


#### 对比发现混淆后的jar是没有throw Exception的，这里的gradle版本是1.5.0，仔细观察发现map的泛型也没有。

#### 再来一张gradle 2.3.3 版本的(因为我Studio版本是2.3.3的)，有泛型没有throw Exception

![0005](https://github.com/jackyZuo/ExceptionDemo/blob/master/images/0005.png)


#### 最后放上三个对比的

```
//    混淆后 gradle 1.5.0
//    public Map encryptParams(Map var1) {
//        return var1;
//    }
    
//    混淆后 gradle 2.3.3
//    public Map<String, String> encryptParams(Map<String, String> var1) {
//        return var1;
//    }

    //混淆前
    public Map<String, String> encryptParams(Map<String, String> params) throws Exception {
        return params;
    }
```


### 结论

#### gradle 1.5.0版本 在开启混淆生成jar的时候会把泛型和throw Exception去掉，gradle 2.3.3版本开启有泛型无throw Exception。原因暂未查到，有清楚的欢迎讨论。


