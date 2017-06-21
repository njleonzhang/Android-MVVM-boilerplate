# Android-MVVM-boilerplate
Android MVVM boilerplate inspired by [android-boilerplate](https://github.com/ribot/android-boilerplate) and powered by [data-binding](https://developer.android.com/topic/libraries/data-binding/index.html)

## Archetcture
![](https://cdn.rawgit.com/njleonzhang/Android-MVVM-boilerplate/master/assets/archtecure.png)
It's similar to `android-boilerplate`, differences:
* `Presenter` to `ViewModel`
* `EventBus` to `RxBus`
* `shareReferenceHelper` is not proxied by data manager, but a static tools.

## Tech-stack
* Data-Binding
* RxJava2
* Retrofit2
* OKHttp

## Code Organization
![](https://cdn.rawgit.com/njleonzhang/Android-MVVM-boilerplate/master/assets/code_organization.png)

* binding —> binding adapters for databinding
* data —> Model(network, database)
* ui —> View and ViewModel(ui and business logic)
* util —> common tools
* widget —> common widget

## UML
![](https://cdn.rawgit.com/njleonzhang/Android-MVVM-boilerplate/master/assets/uml2.png)
---
![](https://cdn.rawgit.com/njleonzhang/Android-MVVM-boilerplate/master/assets/uml1.png)
---
![](https://cdn.rawgit.com/njleonzhang/Android-MVVM-boilerplate/master/assets/uml3.png)

## Details

### NetWork

### recycle view binding

### Activity and Fragment binding

