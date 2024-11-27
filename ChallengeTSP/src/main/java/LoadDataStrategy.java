package com.hotsno;

import java.io.IOException;

/** Interface for loading data. Children must implement a strategy.
 *
 * @author Andrew Kulakovsky
 * @author Michael Wilson
 * @version 1.0
 */
public interface LoadDataStrategy {
    void loadData(String path) throws IOException;
}
