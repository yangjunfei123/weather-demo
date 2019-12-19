package com.neil.example.weatherdemo.network

object ErrorCode {
    val error_network = 1

    val error_data_parse = 2000

    val error_return_server = 3000

    val error_bitmap_load = 4000
    val error_bitmap_load_canceld = 4001

    val error_msg_network = "network error, please check your network and try again"
    val error_msg_data_parse = "data convert failed"
    val error_msg_bitmap_load = "load bitmap failed"
    val error_msg_bitmap_load_canceled = "bitmap load has been canceled"
}