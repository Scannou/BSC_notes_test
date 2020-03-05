# BSC Notes test app

This is a simple test app project for BSC company. I'm quite fluent with Java and this was my first time working with Kotlin after about 6 months. 
Really like the language, would prefer to work in it more and make it my primary one.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them

```
Android Studio
```

## Coroutines

I'm very fluent with RxJava, switching to Coroutines took a bit of getting used to and I probably should have also used Flow with it. Next time...

## Unit tests

I think it's best to note that unit testing was not a priority for either of my previous / current employers, could learn a thing or two about this part. But some tests are included.

## App architecture

App is done in MVVM. With a standard project I'd make many things more abstract for better reusability. In this project, things are simplified. To save time I also used a shared VM for both Fragments (normally I likely wouldn't do that).

## Error handling

There are a few bugs (mainly regarding network availability), I'm aware.

## Dependencies used

* [Kotlin](https://kotlinlang.org/) - The better Java sibling
* [Navigation components](https://developer.android.com/guide/navigation) - Navigation graphs, etc.
* [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Proper async tasks
* [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
* [OkHttp](https://square.github.io/okhttp/) - OkHttp is an HTTP client that’s efficient
* [Mockito](https://site.mockito.org/) - Unit test mocking framework

And some others...

## Authors

* **Marek Feifrlik** - *Initial work* - [Scannou](https://github.com/Scannou)
