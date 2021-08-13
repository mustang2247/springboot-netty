//package com.mustang.netty.schedul;
//
///**
// * @author Mustang Kong
// * @apiNote
// * @date 2021/8/13
// */
//public final class ScheduledTask {
//
//    volatile ScheduledFuture<?> future;
//
//    /**
//     * 取消定时任务
//     */
//    public void cancel() {
//        ScheduledFuture<?> future = this.future;
//        if (future != null) {
//            future.cancel(true);
//        }
//    }
//}
