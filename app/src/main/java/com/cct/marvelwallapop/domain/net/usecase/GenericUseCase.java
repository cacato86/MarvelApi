package com.cct.marvelwallapop.domain.net.usecase;

import com.cct.marvelwallapop.domain.net.GenericSubscriber;
import com.cct.marvelwallapop.domain.repository.RepositoryInterface;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

public abstract class GenericUseCase<K> {

    public final RepositoryInterface repository;
    private Scheduler subcriberScheduler;
    private Scheduler observableScheduler;
    private Subscription subscription = Subscriptions.empty();

    public GenericUseCase(RepositoryInterface repository) {
        this.repository = repository;
        this.subcriberScheduler = Schedulers.io();
        this.observableScheduler = AndroidSchedulers.mainThread();
    }

    public abstract Observable<K> buildUseCaseObservable();

    public void subscribe(Subscriber<K> subscriber) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(subcriberScheduler)
                .observeOn(observableScheduler)
                .subscribe(subscriber);
    }

    public void subscribe() {
        this.subscription = this.buildUseCaseObservable().subscribeOn(subcriberScheduler)
                .observeOn(observableScheduler).subscribe(new GenericSubscriber<K>(null) {});
    }

    public void unsubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}