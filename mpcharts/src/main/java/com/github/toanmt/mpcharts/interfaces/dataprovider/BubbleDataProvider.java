package com.github.toanmt.mpcharts.interfaces.dataprovider;

import com.github.toanmt.mpcharts.data.BubbleData;

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
