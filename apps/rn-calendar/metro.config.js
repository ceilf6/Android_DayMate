/**
 * Metro configuration for React Native
 * https://github.com/facebook/react-native
 */
const { getDefaultConfig, mergeConfig } = require('@react-native/metro-config');
const path = require('path');

const config = {
    watchFolders: [
        path.resolve(__dirname, '../../'),
    ],
    resolver: {
        nodeModulesPaths: [
            path.resolve(__dirname, 'node_modules'),
        ],
    },
};

module.exports = mergeConfig(getDefaultConfig(__dirname), config);
