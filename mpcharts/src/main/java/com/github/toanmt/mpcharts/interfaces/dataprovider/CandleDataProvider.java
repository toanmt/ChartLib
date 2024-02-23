package com.github.toanmt.mpcharts.interfaces.dataprovider;

import com.github.toanmt.mpcharts.data.CandleData;

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
