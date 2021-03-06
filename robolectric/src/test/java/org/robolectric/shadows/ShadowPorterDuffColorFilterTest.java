package org.robolectric.shadows;

import static android.os.Build.VERSION_CODES.LOLLIPOP;
import static org.assertj.core.api.Assertions.assertThat;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(minSdk = LOLLIPOP)
public class ShadowPorterDuffColorFilterTest {
  @Test
  public void constructor_shouldWork() {
    final PorterDuffColorFilter filter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
    assertThat(filter.getColor()).isEqualTo(Color.RED);
    assertThat(filter.getMode()).isEqualTo(PorterDuff.Mode.ADD);
  }

  @Test
  public void setColor_shouldWork() {
    final PorterDuffColorFilter filter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
    filter.setColor(Color.BLUE);
    assertThat(filter.getColor()).isEqualTo(Color.BLUE);
  }

  @Test
  public void setMode_shouldWork() {
    final PorterDuffColorFilter filter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
    filter.setMode(PorterDuff.Mode.DST_IN);
    assertThat(filter.getMode()).isEqualTo(PorterDuff.Mode.DST_IN);
  }

  @Test
  public void hashCode_returnsDifferentValuesForDifferentModes() {
    PorterDuffColorFilter addFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
    PorterDuffColorFilter dstFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST);

    assertThat(addFilter.hashCode()).isNotEqualTo(dstFilter.hashCode());
  }

  @Test
  public void hashCode_returnsDifferentValuesForDifferentColors() {
    PorterDuffColorFilter blueFilter = new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.ADD);
    PorterDuffColorFilter redFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);

    assertThat(blueFilter.hashCode()).isNotEqualTo(redFilter.hashCode());
  }

  @Test
  public void equals_returnsTrueForEqualObjects() {
    PorterDuffColorFilter filter1 = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
    PorterDuffColorFilter filter2 = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);

    assertThat(filter1).isEqualTo(filter2);
  }

  @Test
  public void equals_returnsFalseForDifferentModes() {
    PorterDuffColorFilter addFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);
    PorterDuffColorFilter dstFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST);

    assertThat(addFilter).isNotEqualTo(dstFilter);
  }

  @Test
  public void equals_returnsFalseForDifferentColors() {
    PorterDuffColorFilter blueFilter = new PorterDuffColorFilter(Color.BLUE, PorterDuff.Mode.ADD);
    PorterDuffColorFilter redFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.ADD);

    assertThat(blueFilter).isNotEqualTo(redFilter);
  }
}
