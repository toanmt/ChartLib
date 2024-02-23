package com.github.toanmt.mpcharts.interfaces.dataprovider;

import com.github.toanmt.mpcharts.components.YAxis.AxisDependency;
import com.github.toanmt.mpcharts.data.BarLineScatterCandleBubbleData;
import com.github.toanmt.mpcharts.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
