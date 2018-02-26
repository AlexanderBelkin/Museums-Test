package com.example.air.museums.utils.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {

    fun ui(): Scheduler

    fun computation(): Scheduler

    fun io(): Scheduler
}