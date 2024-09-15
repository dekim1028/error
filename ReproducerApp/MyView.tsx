import React, {useEffect, useRef, useState} from 'react';
import {
  PixelRatio,
  UIManager,
  findNodeHandle,
  requireNativeComponent,
} from 'react-native';

interface Props {
  data: Array<{url: string}>;
}

const MyViewManager = requireNativeComponent<Props>('MyViewManager');

const createFragment = (viewId: number | null) =>
  UIManager.dispatchViewManagerCommand(
    viewId,
    UIManager.getViewManagerConfig('MyViewManager').Commands.create.toString(),
    [viewId],
  );

export const MyView = () => {
  const [data] = useState([
    {url: 'https://picsum.photos/600'},
    {url: 'https://picsum.photos/600'},
    {url: 'https://picsum.photos/600'},
    {url: 'https://picsum.photos/600'},
    {url: 'https://picsum.photos/600'},
    {url: 'https://picsum.photos/600'},
    {url: 'https://picsum.photos/600'},
  ]);

  const ref = useRef(null);

  useEffect(() => {
    const viewId = findNodeHandle(ref.current);
    createFragment(viewId);
  }, []);

  return <MyViewManager ref={ref} data={data} />;
};
