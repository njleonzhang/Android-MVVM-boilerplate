# Android-MVVM-boilerplate
Android MVVM boilerplate inspired by [android-boilerplate](https://github.com/ribot/android-boilerplate) and powered by [data-binding](https://developer.android.com/topic/libraries/data-binding/index.html)

## Archetcture
![](https://cdn.rawgit.com/njleonzhang/Android-MVVM-boilerplate/master/assets/archtecure.png)

It's similar to [android-boilerplate](https://github.com/ribot/android-boilerplate#architecture), differences:
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

### MVC / MVP / MVVM
We support all 3 in this project.
* Some page is simple, With MVVM, you need create at least 2 new files(class), With MVP, you need more files(class), why not just adopt MVC?
* Someone in your team, does not love MVVM, and used to work in MVP. OK, **Forced love does not last**.
* For all 3 architectures, Activity and Fragment are wrapped and easy to initialize.

Check [base](https://github.com/njleonzhang/Android-MVVM-boilerplate/tree/master/app/src/main/java/com/leon/mvvm/ui/base) folder for more details.

### NetWork
Leverage `Retrofit2` and `RxJava2` to parse response and handle error(including loading) in common place, we just deal with data in business logic.

Check [DataManager](https://github.com/njleonzhang/Android-MVVM-boilerplate/blob/master/app/src/main/java/com/leon/mvvm/data/DataManager.java) for more details

### recycle view binding
No need to write adapter agian and agian, with data-binding and [BaseBindingRecycleViewAdapter](https://github.com/njleonzhang/Android-MVVM-boilerplate/blob/master/app/src/main/java/com/leon/mvvm/utils/BaseBindingRecycleViewAdapter.java), we just need provide a layout file and the array of data, then we get a recycleView

### RxBus
Leverage `Rxjava` to post none-sticky event, no need to override any Activity method, and really easy and clean to use.

Check [RxBus](https://github.com/njleonzhang/Android-MVVM-boilerplate/blob/master/app/src/main/java/com/leon/mvvm/utils/RxBus.java) for more details.