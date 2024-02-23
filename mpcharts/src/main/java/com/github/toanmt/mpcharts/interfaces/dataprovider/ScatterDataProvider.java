package com.github.toanmt.mpcharts.interfaces.dataprovider;

import com.github.toanmt.mpcharts.data.ScatterData;

public interface ScatterDataProvider extends BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
