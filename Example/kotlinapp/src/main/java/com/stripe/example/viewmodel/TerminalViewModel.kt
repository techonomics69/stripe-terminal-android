package com.stripe.example.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.stripe.stripeterminal.model.external.DeviceType

class TerminalViewModel(var deviceType: DeviceType, private var _simulated: Boolean = false) : BaseObservable() {

    var deviceTypePosition: Int
        @Bindable get() = deviceType.ordinal
        @Bindable set(value) {
            val newType = DeviceType.values()[value]
            if (deviceType != newType) {
                deviceType = newType
                notifyPropertyChanged(BR.deviceTypePosition)
            }
        }

    var simulated: Boolean
        @Bindable get() = _simulated
        set(value) {
            if (_simulated != value) {
                _simulated = value
                notifyPropertyChanged(BR.simulated)
            }
        }
}
