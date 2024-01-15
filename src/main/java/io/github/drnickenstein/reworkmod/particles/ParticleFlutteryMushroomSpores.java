package io.github.drnickenstein.reworkmod.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ParticleFlutteryMushroomSpores extends TextureSheetParticle {

    ParticleFlutteryMushroomSpores(ClientLevel pLevel, SpriteSet pSprites, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY - 0.125D, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.setSize(0.01F, 0.01F);
        this.pickSprite(pSprites);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
        this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }

    @Override
    public ParticleRenderType getRenderType() {

        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;

    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {

            sprites = spriteSet;

        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeed, double ySpeed, double zSpeed) {

            ParticleFlutteryMushroomSpores particle = new ParticleFlutteryMushroomSpores(level, this.sprites, xCoordIn, yCoordIn, zCoordIn, xSpeed, ySpeed, zSpeed);

            particle.lifetime = Mth.randomBetweenInclusive(level.random, 500, 1000);
            particle.gravity = 0.01F;
            particle.setColor(1.0f, 0.4f, 0.2f);

            return particle;
        }

    }
}
