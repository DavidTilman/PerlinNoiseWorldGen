# PerlinNoiseWorldGen

Procedural 2D tile-map generation in Java using fractal Perlin noise, rendered with
Swing and a pixel-art tileset.

## How it works

1. **Noise** — `NoiseMapGenerator` implements Perlin noise from scratch and layers
   several octaves into a fractal noise map (seed, scale, octaves, persistence and
   lacunarity are configurable; the world uses 4 octaves at scale 8).
2. **Terrain** — the noise map is sampled at the *corners* of each grid cell and
   thresholded into terrain groups: `SHALLOW` water (> 0.7), `BEACH` (> 0.5) and
   `GRASS`.
3. **Tiling** — each cell picks a sprite whose four corner terrains match the four
   sampled corners (`SPRITE.fromEdges`), so grass/sand/water transitions line up
   seamlessly. When several sprites match, one is chosen at random for variety.
4. **Rendering** — `World` is a `JPanel` that draws each tile's sprite, cut from the
   sprite sheet by `SpriteSheet`, scaled up to 32 px cells.

## Running

Requires a JDK (Java 17+ recommended). Run from the repository root so the
`assets/` path resolves:

```sh
javac -d out src/*.java
java -cp out Main
```

The project can also be opened directly in IntelliJ IDEA (`PerlinNoiseWorldGen.iml`).

## Files

| File | Description |
|------|-------------|
| `src/Main.java` | Creates the world and window |
| `src/World.java` | Builds the tile grid from noise and paints it |
| `src/NoiseMapGenerator.java` | Perlin noise and octave layering |
| `src/SPRITE.java`, `src/SPRITEGROUP.java` | Sprite catalogue keyed by corner terrain |
| `src/SpriteSheet.java` | Sprite sheet slicing |
| `src/Tile.java`, `src/Rect.java`, `src/Vector2.java` | Grid and geometry helpers |
| `assets/` | Tileset images |
