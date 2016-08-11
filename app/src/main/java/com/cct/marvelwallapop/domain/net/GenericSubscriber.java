package com.cct.marvelwallapop.domain.net;

import android.content.Context;
import android.widget.Toast;

import rx.Subscriber;

public abstract class GenericSubscriber<K> extends Subscriber<K> {

    private final Context context;

    public GenericSubscriber(Context context) {
        this.context = context;
    }

    public GenericSubscriber() {
        this.context = null;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        if (context != null) {
            Toast.makeText(context, "Error: " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNext(K k) {

    }
}
