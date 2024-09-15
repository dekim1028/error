/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React from 'react';
import {View} from 'react-native';

import {MyView} from './MyView';

function App(): React.JSX.Element {
  return (
    <View style={{flex: 1}}>
      <MyView />
    </View>
  );
}

export default App;
