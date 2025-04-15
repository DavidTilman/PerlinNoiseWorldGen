

import java.util.Map;
import java.util.Random;

public class NoiseMapGenerator {
    private final int mapWidth, mapHeight;
    Vector2[][] gradientVectors;

    public NoiseMapGenerator(int mapWidth, int mapHeight) {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }

    public static double lerp(double a, double b, double f) {
        return a + f * (b - a);
    }

    public static double iLerp(double a, double b, double f) {
        return (f-a)/(b-a);
    }


    public double[][] generateNoiseMap(int seed, int scale, int octaves, double persistence, double lacunarity) {
        int noiseMapWidth = Math.ceilDiv(mapWidth, scale)+1;
        int noiseMapHeight = Math.ceilDiv(mapHeight, scale)+1;
        gradientVectors = new Vector2[noiseMapWidth][noiseMapHeight];
        for (int x = 0; x < noiseMapWidth; x++) {
            for (int y = 0; y < noiseMapHeight; y++) {
                gradientVectors[x][y] = Vector2.random();
            }
        }

        Random rand = new Random(seed);

        double[][] noiseMap = new double[mapWidth][mapHeight];

        double maxNoise = Double.MIN_VALUE;
        double minNoise = Double.MAX_VALUE;

        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                double amplitude = 1;
                double frequency = 1;
                double noiseHeight = 0;

                for (int i = 0; i < octaves; i++) {
                    double sampleX = ((double)x / scale) * frequency;
                    double sampleY = ((double)y / scale) * frequency;
                    double perlinValue = this.perlinNoise(sampleX,sampleY);



                    noiseHeight += perlinValue * amplitude;
                    frequency *= lacunarity;
                    amplitude *= persistence;
                }
                noiseMap[x][y] = noiseHeight;
                if (noiseHeight > maxNoise) {
                    maxNoise = noiseHeight;
                }
                if (noiseHeight < minNoise) {
                    minNoise = noiseHeight;
                }
            }
        }

        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                noiseMap[x][y] = iLerp(minNoise, maxNoise, noiseMap[x][y]);
            }
        }

        return noiseMap;
    }

    public double perlinNoise(double sampleX, double sampleY) {
        int gridX, gridY;

        Vector2 v = new Vector2(sampleX,sampleY);

        gridX = (int) Math.floor(sampleX);
        gridY = (int) Math.floor(sampleY);

        Vector2 tlg, trg, blg, brg;

        tlg = gradientVectors[gridX][gridY];
        trg = gradientVectors[gridX+1][gridY];
        blg = gradientVectors[gridX][gridY+1];
        brg = gradientVectors[gridX+1][gridY+1];

        Vector2 tlo, tro, blo, bro;
        tlo = v.sub(new Vector2(gridX, gridY));
        tro = v.sub(new Vector2(gridX+1, gridY));
        blo = v.sub(new Vector2(gridX, gridY+1));
        bro = v.sub(new Vector2(gridX+1, gridY+1));

        double tld, trd, bld, brd;
        tld = tlg.dot(tlo);
        trd = trg.dot(tro);
        bld = blg.dot(blo);
        brd = brg.dot(bro);

        double i1 = lerp(tld, trd, tlo.getX());
        double i2 = lerp(bld, brd, tlo.getX());
        double i3 = lerp(i1, i2, tlo.getY());
        return i3;
    }
}
