# MEventNice

MEventNice is a publish/subscribe event bus for Java.

An event bus designed to decouple different parts of your application while still allowing them to communicate
efficiently.

## Task completion

V1.0 completed:

1. 完成捕猎者捕获相关事件接收器
2. 简单实现事件接收器注册至事件接收器注册中心
3. 简单实现事件接收器从注册中心注销
4. 简单实现事件调度器对匹配已注册的事件的接收器方法（事件）的分发

V1.0.1 completed:

1. 实现对Event事件多继承功能的支持
2. 实现对自定义Event事件支持及自定义Event多继承的支持
3. 实现对事件接收器多继承功能的支持

V1.0.2 completed:
1. 对捕猎者捕获相关事件接收器流程优化支持缓存，提升捕获效率
2. 对方法捕获流程优化支持缓存，提升捕获效率
3. 解决前版本的异常bug

## License

```txt
Copyright 2021 MRyan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```